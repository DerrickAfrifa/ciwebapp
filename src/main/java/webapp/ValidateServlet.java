package webapp;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.shacl.validation.ReportEntry;

import com.google.gson.Gson;
/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate.jsp")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filePath = request.getParameter("filePath");
		List<ReportEntry> entries = ShaclService.getReportEntries(filePath);
		List<String[]> entryListObject = ShaclService.getEntryListObject(entries);
		System.out.println("entryListObject: " + entryListObject);
		HashMap<String, Integer> validationReportMap = ShaclService.getViolationReport(entries);
		Gson gsonObj = new Gson();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		int totalViolations = 0;

		for (Map.Entry<String, Integer> entry : validationReportMap.entrySet()) {
		    map = new HashMap<Object, Object>();
		    map.put("label", entry.getKey());
		    map.put("y", entry.getValue());
		    list.add(map);
		    totalViolations += entry.getValue();
		}
		String dataPoints = gsonObj.toJson(list);
		
		request.setAttribute("entries", entryListObject);
		request.setAttribute("data", dataPoints);
		request.setAttribute("totalViolations", totalViolations);
		request.getRequestDispatcher("/WEB-INF/views/validate.jsp").forward(request, response);
	}

}
