package webapp;

import java.util.*;
import org.apache.jena.graph.Graph;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shacl.ShaclValidator;
import org.apache.jena.shacl.Shapes;
import org.apache.jena.shacl.ValidationReport;
import org.apache.jena.shacl.lib.ShLib;
import org.apache.jena.shacl.validation.ReportEntry;

public class ShaclService {
	private final static String SHAPES_PATH = "/home/afrifad/uni/dissertation/constraints3.ttl";

	public static HashMap<String, Integer> getViolationReport(List<ReportEntry> entries) {
		HashMap<String, Integer> freqs = new HashMap<>();
		for (ReportEntry e : entries) {
			if (freqs.containsKey(e.message())) {
				freqs.replace(e.message(), freqs.get(e.message()) + 1);
			} else {
				freqs.put(e.message(), 1);
			}
		}
		return freqs;
	}

	public static List<ReportEntry> getReportEntries(String filePath) {
		String DATA_PATH = filePath;

		Graph shapesGraph = RDFDataMgr.loadGraph(SHAPES_PATH);
		Graph dataGraph = RDFDataMgr.loadGraph(DATA_PATH);

		Shapes shapes = Shapes.parse(shapesGraph);

		ValidationReport report = ShaclValidator.get().validate(shapes, dataGraph);
		ShLib.printReport(report);
		List<ReportEntry> entries = (List<ReportEntry>) report.getEntries();
		return entries;
	}
	
	public static List<String[]> getEntryListObject(List<ReportEntry> entries){
		List<String[]> list = new ArrayList<>();
		for(ReportEntry e: entries) {
			String localName = e.focusNode().getLocalName();
			String URI = e.focusNode().getURI();
			String message = e.message();
			String[] array = {localName, URI, message};
			list.add(array);
		}
		return list;
	}

	public static void main(String[] args) {
		String SHAPES = "/home/afrifad/uni/dissertation/constraints3.ttl";
		String DATA = "/home/afrifad/uni/dissertation/fresh-stuff/v1.ttl";

		Graph shapesGraph = RDFDataMgr.loadGraph(SHAPES);
		Graph dataGraph = RDFDataMgr.loadGraph(DATA);

		Shapes shapes = Shapes.parse(shapesGraph);

		ValidationReport report = ShaclValidator.get().validate(shapes, dataGraph);
        ShLib.printReport(report);
		Collection<ReportEntry> entries = (List<ReportEntry>) report.getEntries();

        for(ReportEntry e: entries) {
        	System.out.println("GETTING URI:");
        	System.out.println(e.focusNode().getURI());
        	System.out.println("GETTING MSG:");
        	System.out.println(e.message());
        	System.out.println("GETTING LOCAL NAME:");
        	System.out.println(e.focusNode().getLocalName());
        	
//        	System.out.println("Above is an entry");
        	System.out.println();
        }
		RDFDataMgr.write(System.out, report.getModel(), Lang.TTL);

	}

}
