package webapp;

import java.util.*;

import org.apache.jena.graph.Node;
import org.apache.jena.iri.impl.Main;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import org.apache.jena.util.FileManager;

public class SparqlService {
	public String fileMessage(String filename) {
		return "Filename was " + filename;
	}
	
	private static Map<String, String> queries = SparqlService.createQueryMap();
	
	private static Map<String, String> createQueryMap() {
	    Map<String,String> myMap = new HashMap<String,String>();
	    myMap.put("pdc", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	filter not exists { ?dataHandling dpv:hasPersonalDataCategory ?personalDataCategory } .\n" + 
	    		"}");
	    myMap.put("dsubj", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	filter not exists { ?dataHandling dpv:hasDataSubject ?dataSubject } .\n" + 
	    		"}");
	    myMap.put("dsrc", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	filter not exists { ?dataHandling <http://ontology.example.org/ci#hasDataSource> ?dataSource } .\n" + 
	    		"}");
	    myMap.put("rec", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	filter not exists { ?dataHandling dpv:hasRecipient ?dataRecipient } .\n" + 
	    		"}");
	    myMap.put("pur", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" +
	    		"	filter not exists { ?dataHandling dpv:hasPurpose ?purpose } .\n" + 
	    		"}");
	    myMap.put("tom", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	?dataHandling dpv:hasProcessing ?processing .\n" + 
	    		"	filter not exists { ?dataHandling dpv:hasTechnicalOrganisationalMeasure ?technicalOrganisationalMeasure } .\n" + 
	    		"}");
	    myMap.put("vag", "SELECT ?dataHandling\n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	?dataHandling <http://ontology.example.org/ci#hasViolation> ?violation .\n" + 
	    		"}");
	    myMap.put("tid", "SELECT ?dataHandling \n" + 
	    		"WHERE\n" + 
	    		"{\n" + 
	    		"	?dataHandling a dpv:PersonalDataHandling .\n" + 
	    		"	?dataHandling dpv:hasRecipient ?dataRecipient .\n" + 
	    		"	?dataRecipient a dpv:ThirdParty .\n" + 
	    		"	?ThirdParty <http://ontology.example.org/ci#hasIdentity> ?identity .\n" + 
	    		"	filter (?identity = \"false\"^^<http://www.w3.org/2001/XMLSchema#boolean>)\n" + 
	    		"}");
	    return myMap;
	}
	
	public static List<String> getQueryResult(String filePath, String queryType) {
		List<String> nodes = new ArrayList();
		FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
//		Model model = FileManager.get().loadModel("/home/afrifad/uni/dissertation/fresh-stuff/v1.ttl");
		Model model = FileManager.get().loadModel(filePath);
		
		String queryString = "PREFIX dpv: <http://w3.org/ns/dpv#>PREFIX ci: <http://www.semanticweb.org/afrifad/ontologies/2020/1/contextual_integrityV2#>" +
				"SELECT ?dataHandling\n" + 
				"WHERE\n" + 
				"{\n" + 
				"	?dataHandling a dpv:PersonalDataHandling .\n" + 
				"	filter not exists { ?dataHandling dpv:hasPersonalDataCategory ?personalDataCategory } .\n" + 
				"}";
		String queryString2 = "PREFIX dpv: <http://w3.org/ns/dpv#>PREFIX ci: <http://www.semanticweb.org/afrifad/ontologies/2020/1/contextual_integrityV2#>" +
				SparqlService.queries.get(queryType);
		Query query = QueryFactory.create(queryString2);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		String varName = "";
		try {
			ResultSet results = qexec.execSelect();
			System.out.println("executing result set");
			while(results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				Iterator<String> it = soln.varNames();
				while (it.hasNext()) {
					varName = (String) it.next();
//					System.out.println("varname "+varName);
					Resource resource = soln.getResource(varName);
					Node n = resource.asNode();
//					System.out.println("as name " + soln.getResource(varName));
//					System.out.println("uri " + n.getURI());
					nodes.add(n.getURI());
				}
//				Resource name = soln.getResource(varName);
//				System.out.println("name "+name);
			}
		} finally {
			qexec.close();
		}
		return nodes;
	}
	
	public static String runDefaultQuery(String filePath) {
		System.out.println("in function");
		FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
		Model model = FileManager.get().loadModel("/home/afrifad/uni/dissertation/fresh.ttl");
		
		String queryString = "PREFIX ci: <http://www.semanticweb.org/afrifad/ontologies/2020/1/contextual_integrityV2#>" +
				"select ?dh ?name where { ?dh ci:hasPrivacyPolicy ?pp . ?pp ci:name ?name }";
		
		String qs2 = "PREFIX ci: <http://ontology.example.org/ci#>" + 
				"SELECT ?dataHandling\n" + 
				"WHERE\n" + 
				"{\n" + 
				"	?dataHandling a dpv:PersonalDataHandling .\n" + 
				"	filter not exists { ?dataHandling dpv:hasPersonalDataCategory ?personalDataCategory } .\n" + 
				"}";
		Query query = QueryFactory.create(qs2);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				Iterator<String> it = soln.varNames();
				while (it.hasNext()) {
					String varName = (String) it.next();
					System.out.println(varName);
				}
				Resource name = soln.getResource("dh");
				Literal policy = soln.getLiteral("name");
				System.out.println("result: " + policy.getString());
				
				return policy.getString();
				//System.out.println(name);
			}
		} finally {
			// TODO: handle finally clause
			qexec.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(SparqlService.runDefaultQuery("rand"));
	}
}
