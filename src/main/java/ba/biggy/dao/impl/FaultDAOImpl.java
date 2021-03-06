package ba.biggy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ba.biggy.dao.FaultDAO;
import ba.biggy.global.Constants;
import ba.biggy.model.Fault;


public class FaultDAOImpl implements FaultDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public FaultDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	/**
	 * Inserts or updates a fault
	 */
	@Override
	public void saveOrUpdate(Fault fault) {

		
		if(fault.getIdFault() > 0) {
			//update
			
			String sql = "UPDATE " + Constants.FAULT_TABLE_NAME + " SET "
					+ Constants.FAULT_TABLE_LAST_EDIT_COLUMN + "=?, "
					+ Constants.FAULT_TABLE_SERIAL_NUMBER_COLUMN + "=?, "
					+ Constants.FAULT_TABLE_PRODUCT_ID_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_NAME_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_STREET_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_POSTAL_CODE + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_EMAIL_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_NOTE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_BY_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_TYPE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_PRIORITY_COLUMN + "=? "
	        		+ "WHERE " 
	        		+ Constants.FAULT_TABLE_ID_COLUMN + "=?";
	        
			jdbcTemplate.update(sql, 
					fault.getLastEdit(),
	        		fault.getProductSerialNumber(),
	        		fault.getProductId(),
	        		fault.getClientName(), 
	        		fault.getClientStreet(), 
	        		fault.getClientPostalCode(),
	        		fault.getClientPlace(), 
	        		fault.getClientPhoneOne(), 
	        		fault.getClientPhoneTwo(), 
	        		fault.getClientEmail(), 
	        		fault.getFaultDescription(), 
	        		fault.getFaultNote(), 
	        		fault.getFaultIssuedTo(), 
	        		fault.getFaultIssuedBy(),
	        		fault.getFaultType(), 
	        		fault.getFaultPriority(),
	        		fault.getIdFault());
	        
		}else {
			//insert
			
			String sql = "INSERT INTO " + Constants.FAULT_TABLE_NAME + " ("
	        		+ Constants.FAULT_TABLE_DATE_TIME_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_SERIAL_NUMBER_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_PRODUCT_ID_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_PRODUCT_TYPE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_NAME_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_STREET_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_POSTAL_CODE + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_EMAIL_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_NOTE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_BY_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_TYPE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_PRIORITY_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_FAULT_FAULT_LAT + ", "
	        		+ Constants.FAULT_TABLE_FAULT_FAULT_LNG + ")"
	                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
			jdbcTemplate.update(sql,
	        		fault.getDateTime(),
	        		fault.getProductSerialNumber(),
	        		fault.getProductId(), 
	        		fault.getProductType(), 
	        		fault.getClientName(), 
	        		fault.getClientStreet(), 
	        		fault.getClientPostalCode(),
	        		fault.getClientPlace(), 
	        		fault.getClientPhoneOne(), 
	        		fault.getClientPhoneTwo(), 
	        		fault.getClientEmail(), 
	        		fault.getFaultDescription(), 
	        		fault.getFaultNote(), 
	        		fault.getFaultIssuedTo(), 
	        		fault.getFaultIssuedBy(),
	        		fault.getFaultType(), 
	        		fault.getFaultPriority(),
	        		fault.getFaultStatus(),
	        		fault.getFaultLat(),
	        		fault.getFaultLng());
		}
		
	}
	
	
	/**
	 * Returns a list of faults with a status "UrgentToDo" in the "faultStatus" column
	 */
	@Override
	public List<Fault> listToDoFaults() {
		String sql = "SELECT * FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + " = '"+ Constants.FAULT_TABLE_TO_DO_STATUS +"'";
	    List<Fault> faultsToDo = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setIdFault(rs.getInt(Constants.FAULT_TABLE_ID_COLUMN));
	            faults.setDateTime(rs.getDate(Constants.FAULT_TABLE_DATE_TIME_COLUMN));
	            faults.setProductId(rs.getString(Constants.FAULT_TABLE_PRODUCT_ID_COLUMN));
	            faults.setProductType(rs.getString(Constants.FAULT_TABLE_PRODUCT_TYPE_COLUMN));
	            faults.setClientName(rs.getString(Constants.FAULT_TABLE_CLIENT_NAME_COLUMN));
	            faults.setClientStreet(rs.getString(Constants.FAULT_TABLE_CLIENT_STREET_COLUMN));
	            faults.setClientPostalCode(rs.getString(Constants.FAULT_TABLE_CLIENT_POSTAL_CODE));
	            faults.setClientPlace(rs.getString(Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN));
	            faults.setClientPhoneOne(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN));
	            faults.setClientPhoneTwo(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN));
	            faults.setFaultDescription(rs.getString(Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN));
	            faults.setFaultNote(rs.getString(Constants.FAULT_TABLE_FAULT_NOTE_COLUMN));
	            faults.setFaultIssuedTo(rs.getString(Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN));
	            faults.setFaultType(rs.getString(Constants.FAULT_TABLE_FAULT_TYPE_COLUMN));
	            faults.setFaultPriority(rs.getString(Constants.FAULT_TABLE_FAULT_PRIORITY_COLUMN));
	            faults.setFaultLat(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LAT));
	            faults.setFaultLng(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LNG));
	     
	            return faults;
	        }
	 
	    });
	 
	    return faultsToDo;
		
	}
	
	
	/**
	 * Returns a list of faults with a status "UrgentToDo" in the "faultStatus" column and provided serviceman name in the "issuedTo" column
	 */
	@Override
	public List<Fault> listFaultsByServiceman (String serviceman) {
		String sql = "SELECT * FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + " = '"+ Constants.FAULT_TABLE_TO_DO_STATUS +"'" + " AND " + 
					Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN + " = '"+ serviceman +"'";
	    List<Fault> faultsToDo = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setIdFault(rs.getInt(Constants.FAULT_TABLE_ID_COLUMN));
	            faults.setDateTime(rs.getDate(Constants.FAULT_TABLE_DATE_TIME_COLUMN));
	            faults.setProductId(rs.getString(Constants.FAULT_TABLE_PRODUCT_ID_COLUMN));
	            faults.setProductType(rs.getString(Constants.FAULT_TABLE_PRODUCT_TYPE_COLUMN));
	            faults.setClientName(rs.getString(Constants.FAULT_TABLE_CLIENT_NAME_COLUMN));
	            faults.setClientStreet(rs.getString(Constants.FAULT_TABLE_CLIENT_STREET_COLUMN));
	            faults.setClientPostalCode(rs.getString(Constants.FAULT_TABLE_CLIENT_POSTAL_CODE));
	            faults.setClientPlace(rs.getString(Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN));
	            faults.setClientPhoneOne(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN));
	            faults.setClientPhoneTwo(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN));
	            faults.setFaultDescription(rs.getString(Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN));
	            faults.setFaultNote(rs.getString(Constants.FAULT_TABLE_FAULT_NOTE_COLUMN));
	            faults.setFaultIssuedTo(rs.getString(Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN));
	            faults.setFaultType(rs.getString(Constants.FAULT_TABLE_FAULT_TYPE_COLUMN));
	            faults.setFaultPriority(rs.getString(Constants.FAULT_TABLE_FAULT_PRIORITY_COLUMN));
	            faults.setFaultLat(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LAT));
	            faults.setFaultLng(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LNG));
	     
	            return faults;
	        }
	 
	    });
	 
	    return faultsToDo;
		
	}


	/**
	 * Returns a fault object with a specific id
	 */
	@Override
	public Fault getFaultById(int faultId) {
		String sql = "SELECT * FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_ID_COLUMN + "=" + faultId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Fault>() {

			@Override
			public Fault extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Fault fault = new Fault();
					
					fault.setIdFault(rs.getInt(Constants.FAULT_TABLE_ID_COLUMN));
		            fault.setDateTime(rs.getDate(Constants.FAULT_TABLE_DATE_TIME_COLUMN));
		            fault.setProductId(rs.getString(Constants.FAULT_TABLE_PRODUCT_ID_COLUMN));
		            fault.setProductSerialNumber(rs.getString(Constants.FAULT_TABLE_SERIAL_NUMBER_COLUMN));
		            fault.setClientName(rs.getString(Constants.FAULT_TABLE_CLIENT_NAME_COLUMN));
		            fault.setClientStreet(rs.getString(Constants.FAULT_TABLE_CLIENT_STREET_COLUMN));
		            fault.setClientPostalCode(rs.getString(Constants.FAULT_TABLE_CLIENT_POSTAL_CODE));
		            fault.setClientPlace(rs.getString(Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN));
		            fault.setClientPhoneOne(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN));
		            fault.setClientPhoneTwo(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN));
		            fault.setClientEmail(rs.getString(Constants.FAULT_TABLE_CLIENT_EMAIL_COLUMN));
		            fault.setFaultDescription(rs.getString(Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN));
		            fault.setFaultNote(rs.getString(Constants.FAULT_TABLE_FAULT_NOTE_COLUMN));
		            fault.setFaultIssuedTo(rs.getString(Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN));
		            fault.setFaultIssuedBy(rs.getString(Constants.FAULT_TABLE_FAULT_ISSUED_BY_COLUMN));
		            fault.setFaultType(rs.getString(Constants.FAULT_TABLE_FAULT_TYPE_COLUMN));
		            fault.setFaultPriority(rs.getString(Constants.FAULT_TABLE_FAULT_PRIORITY_COLUMN));
		            fault.setFaultLat(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LAT));
		            fault.setFaultLng(rs.getDouble(Constants.FAULT_TABLE_FAULT_FAULT_LNG));
					
		            
					return fault;
				}
				return null;
			}
			
		});
	}


	/**
	 * Sets a fault status in "faultStatus" column from "UrgentToDo" to "ServiceDone"
	 */
	@Override
	public void archiveFault(int faultId) {
		String sql = "UPDATE " + Constants.FAULT_TABLE_NAME + " SET " + Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + "=? WHERE " + Constants.FAULT_TABLE_ID_COLUMN + "=?";
        jdbcTemplate.update(sql, Constants.FAULT_TABLE_DONE_STATUS, faultId);
	}


	/**
	 * Deletes a fault with a specified id
	 */
	@Override
	public void deleteFault(int faultId) {
		String sql = "DELETE FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_ID_COLUMN + "=?";
	    jdbcTemplate.update(sql, faultId);
	}

	
	
	@Override
	public int toDoFaultCount() {
		String sql = "SELECT COUNT(*) FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + "=?"; 
		  return jdbcTemplate.queryForObject(sql, new Object[] {Constants.FAULT_TABLE_TO_DO_STATUS}, Integer.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
