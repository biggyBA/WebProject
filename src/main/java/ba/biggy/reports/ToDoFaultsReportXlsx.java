package ba.biggy.reports;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import ba.biggy.model.Fault;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


@Component("toDoFaultsXlsxView")
public class ToDoFaultsReportXlsx extends AbstractView {

	private JasperReport toDoFaultsReport;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		response.setContentType("application/xlsx");
		
		List<Fault> faults = (List<Fault>) model.get("toDoFaults");
		//data source
        JRDataSource dataSource = getDataSource(faults);
        //compile jrxml template and get report
        JasperReport report = getReport();
        //fill the report with data source objects
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, dataSource);
        
        
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C://sample_report.xls");

        exporter.exportReport();
		
	}
	
	private JRDataSource getDataSource (List<Fault> faults) {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(faults);
		return dataSource;
	}
	
	public JasperReport getReport() throws JRException {
		if (toDoFaultsReport == null) {
			InputStream stream = getClass().getResourceAsStream("/jasperReports/pdfReports/toDoFaultsPdf.jrxml");
			toDoFaultsReport = JasperCompileManager.compileReport(stream);
		}
		return toDoFaultsReport;
	}

}
