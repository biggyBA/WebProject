package ba.biggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	        		+ Constants.FAULT_TABLE_SERIAL_NUMBER_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_NAME_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_STREET_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_CLIENT_EMAIL_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_NOTE_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_ISSUED_BY_COLUMN + "=?, "
	        		+ Constants.FAULT_TABLE_FAULT_TYPE_COLUMN + "=? "
	        		+ "WHERE " 
	        		+ Constants.FAULT_TABLE_ID_COLUMN + "=?";
	        
			/*jdbcTemplate.update(sql, 
	        		fault.getIdent(), 
	        		fault.getSerialNumber(), 
	        		fault.getClient(), 
	        		fault.getStreet(), 
	        		fault.getPlace(), 
	        		fault.getPhoneOne(), 
	        		fault.getPhoneTwo(), 
        			fault.getFaultDescription(), 
        			fault.getNote(), 
        			fault.getServiceman(), 
        			fault.getOrderBy(), 
        			fault.getTypeOfService(), 
        			fault.getId());*/
	        
		}else {
			//insert
			
			String sql = "INSERT INTO " + Constants.FAULT_TABLE_NAME + " ("
	        		+ Constants.FAULT_TABLE_DATE_TIME_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_SERIAL_NUMBER_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_PRODUCT_ID_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_PRODUCT_TYPE_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_NAME_COLUMN + ", "
	        		+ Constants.FAULT_TABLE_CLIENT_STREET_COLUMN + ", "
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
	        		+ Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + ")"
	                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
			jdbcTemplate.update(sql,
	        		fault.getDateTime(),
	        		fault.getProductSerialNumber(),
	        		fault.getProductId(), 
	        		fault.getProductType(), 
	        		fault.getClientName(), 
	        		fault.getClientStreet(), 
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
	        		fault.getFaultStatus());
		}
		
	}
	
	
	@Override
	public List<Fault> listToDoFaults() {
		String sql = "SELECT * FROM " + Constants.FAULT_TABLE_NAME + " WHERE " + Constants.FAULT_TABLE_FAULT_STATUS_COLUMN + " = '"+ Constants.FAULT_TABLE_TO_DO_STATUS +"'";
	    List<Fault> faultsToDo = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setIdFault(rs.getInt(Constants.FAULT_TABLE_ID_COLUMN));
	            faults.setDateTime(rs.getDate(Constants.FAULT_TABLE_DATE_TIME_COLUMN));
	            faults.setProductType(rs.getString(Constants.FAULT_TABLE_PRODUCT_TYPE_COLUMN));
	            faults.setClientName(rs.getString(Constants.FAULT_TABLE_CLIENT_NAME_COLUMN));
	            faults.setClientStreet(rs.getString(Constants.FAULT_TABLE_CLIENT_STREET_COLUMN));
	            faults.setClientPlace(rs.getString(Constants.FAULT_TABLE_CLIENT_PLACE_COLUMN));
	            faults.setClientPhoneOne(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN));
	            faults.setClientPhoneTwo(rs.getString(Constants.FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN));
	            faults.setFaultDescription(rs.getString(Constants.FAULT_TABLE_FAULT_DESCRIPTION_COLUMN));
	            faults.setFaultNote(rs.getString(Constants.FAULT_TABLE_FAULT_NOTE_COLUMN));
	            faults.setFaultIssuedTo(rs.getString(Constants.FAULT_TABLE_FAULT_ISSUED_TO_COLUMN));
	            faults.setFaultType(Constants.FAULT_TABLE_FAULT_TYPE_COLUMN);
	     
	            return faults;
	        }
	 
	    });
	 
	    return faultsToDo;
		
	}

}