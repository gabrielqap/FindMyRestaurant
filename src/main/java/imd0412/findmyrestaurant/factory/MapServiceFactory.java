package imd0412.findmyrestaurant.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.service.IMapService;

public class MapServiceFactory
{
	public static IMapService createService()
	{
		IMapService a = new IMapService() {
			
			@Override
			public GeoCoordinate convertToGeographicCoordinates(String address) {
				URL url;
				String Ad = address;
				Ad = Ad.replace(" ", "+");
				try {
					url = new URL("http://maps.google.com/maps/geo?q=\'" + Ad + "\'&output=xml&key=the_key_you_got_from_google");
					BufferedReader theHTML = new BufferedReader(new InputStreamReader(url.openStream()));
					FileWriter fstream = new FileWriter("url.xml");
					BufferedWriter out = new BufferedWriter(fstream);
					String thisLine;
					while ((thisLine = theHTML.readLine()) != null)
						out.write(thisLine);
		            out.close();
		            File file = new File("url.xml");
		            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		            DocumentBuilder db = dbf.newDocumentBuilder();
		            Document doc = (Document) db.parse(file);
		            ((Node) doc.getDefaultRootElement()).normalize();
		            NodeList nl = ((org.w3c.dom.Document) doc).getElementsByTagName("code");
		            Element n = (Element)nl.item(0);
		            String st = ((Node) n).getFirstChild().getNodeValue();
		            if (st.equals("200")) {
		                NodeList n2 = ((org.w3c.dom.Document) doc).getElementsByTagName("coordinates");
		                Element nn = (Element)n2.item(0);
		                String st1 = ((Node) nn).getFirstChild().getNodeValue();
		               System.out.println("Coordenadas: " + st1);
		            }
		            else {
		            	return null;
		            }
		            
				
				
			}
		        catch (MalformedURLException e) {
		        	System.out.println(e);
		        }
				catch (IOException  e) {
		        	System.out.println(e);
		        }
				catch (Exception e) {
		        	System.out.println(e);
		        }
				return null;
			}
		};
		return a;
	}
	
}
