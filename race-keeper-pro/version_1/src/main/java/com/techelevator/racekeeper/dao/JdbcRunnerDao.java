package com.techelevator.racekeeper.dao;

import com.techelevator.racekeeper.exception.DaoException;
import com.techelevator.racekeeper.model.Runner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunnerDao implements RunnerDao {

    private final JdbcTemplate jdbcTemplate;

    private final String RUNNER_BASE_SQL = "SELECT runner_id, first_name, last_name, street, city, state_code, gender_code, birthday FROM runner ";


    public JdbcRunnerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Runner> getRunners() {
        List<Runner> runners = new ArrayList<>();

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(RUNNER_BASE_SQL + ";");

            while (results.next()) {
                Runner runner = mapRowToRunner(results);
                runners.add(runner);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return runners;
    }

    @Override
    public Runner getRunnerById(int id) {
        Runner runner = null;
        String sql = RUNNER_BASE_SQL +
                "WHERE runner_id = ?;";

        try {

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                runner = mapRowToRunner(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return runner;
    }

    @Override
    public List<Runner> getRunnersByCity(String city) {
        List<Runner> runners = new ArrayList<>();
        String sql = RUNNER_BASE_SQL +
                "WHERE city = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
            while (results.next()) {
                Runner runner = mapRowToRunner(results);
                runners.add(runner);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return runners;
    }

    @Override
    public List<Runner> getFastestRunnersByRace(int raceId, int numToShow) {
        List<Runner> runners = new ArrayList<>();
//        String sql = "SELECT r.last_name, r.first_name, r.city, r.state_code, rr.run_time, rr.run_time / race.race_distance AS pace\n" +
//                "FROM runner r\n" +
//                "JOIN runner_race rr ON r.runner_id = rr.runner_id\n" +
//                "JOIN race ON rr.race_id = ?\n" +
//                "WHERE race.race_id = 1\n" +
//                "ORDER BY rr.run_time\n" +
//                "LIMIT ?;";
//
//        try{
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, raceId, numToShow);
//            while (results.next()){
//
//            }
//        }
        return runners;
    }

    @Override
    public List<Runner> getRunnersByName(String name, boolean useWildCard) {
        List<Runner> runners = new ArrayList<>();
        if (useWildCard) {
            name = "%" + name + "%";
        }
        String sql = RUNNER_BASE_SQL +
                "WHERE CONCAT(first_name || ' ' || last_name) ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                Runner runner = mapRowToRunner(results);
                runners.add(runner);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return runners;
    }



    @Override
    public Runner createRunner(Runner newRunner) {
        Runner runner = null;
        String sql = "INSERT INTO runner (first_name, last_name, street, city, state_code, gender_code, birthday) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING runner_id;";
        try {
            int newId = jdbcTemplate.queryForObject(sql, int.class, newRunner.getFirst_name(), newRunner.getLast_name(), newRunner.getStreet(),
                    newRunner.getCity(), newRunner.getState_code(), newRunner.getGender_code(), newRunner.getBirthday());
            runner = getRunnerById(newId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return runner;
    }

    @Override
    public Runner updateRunner(Runner updatedRunner) {
        Runner runner = null;
        String sql = "UPDATE runner SET first_name=?, last_name=?, street=?, city=?, state_code=?, gender_code=?, birthday=? " +
                "WHERE runner_id = ?;";
        try {
            int rowsUpdated = jdbcTemplate.update(sql, updatedRunner.getFirst_name(), updatedRunner.getLast_name(),
                    updatedRunner.getStreet(), updatedRunner.getCity(), updatedRunner.getState_code(), updatedRunner.getGender_code(),
                    updatedRunner.getBirthday(), updatedRunner.getId());
            if (rowsUpdated == 0) {
                throw new DaoException("Zero rows affected");
            } else {
                runner = getRunnerById(updatedRunner.getId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return runner;
    }


    private Runner mapRowToRunner(SqlRowSet results) {
        Runner runner = new Runner();
        runner.setId(results.getInt("runner_id"));
        runner.setFirst_name(results.getString("first_name"));
        runner.setLast_name(results.getString("last_name"));
        runner.setStreet(results.getString("street"));
        runner.setCity(results.getString("city"));
        runner.setState_code(results.getString("state_code"));
        runner.setGender_code(results.getString("gender_code").charAt(0));
        if (results.getDate("birthday") != null) {
            runner.setBirthday(results.getDate("birthday").toLocalDate());
        }

        return runner;
    }
}
