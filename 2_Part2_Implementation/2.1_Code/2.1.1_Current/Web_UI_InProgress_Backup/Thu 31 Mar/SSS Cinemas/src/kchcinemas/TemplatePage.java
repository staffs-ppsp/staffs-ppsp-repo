package kchcinemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author darthcrap
 */
public class TemplatePage {
	private static Pattern REGEX_SECTIONSTART = Pattern.compile("%(DEFAULT_PROPERTIES|SIDE_TITLE|SIDE_CONTENT|MAIN_TITLE|MAIN_CONTENT)%");
	private static Pattern REGEX_LEFTOVERPROPERTIES = Pattern.compile("\\$\\{[^\\}]+\\}");

	public TemplatePage(String strContents) {
		if (strContents != null) {
			parse(strContents);
		}
	}

	private TemplatePage(TemplatePage objPage) {
		this.plDefaultProperties = objPage.getDefaultProperties().copy();
		this.strSideTitle = objPage.getSideTitle();
		this.strSideContent = objPage.getSideContent();
		this.strMainTitle = objPage.getMainTitle();
		this.strMainContent = objPage.getMainContent();
	}

	private PropertyList plDefaultProperties = new PropertyList();
	private String strSideTitle = "";
	private String strSideContent = "";
	private String strMainTitle = "";
	private String strMainContent = "";

	private void parse(String strContents) {
		HashMap<String,StringBuilder> mapSections = new HashMap<String, StringBuilder>();
		mapSections.put("DEFAULT_PROPERTIES", new StringBuilder());
		mapSections.put("SIDE_TITLE"     ,new StringBuilder());
		mapSections.put("SIDE_CONTENT"   , new StringBuilder());
		mapSections.put("MAIN_TITLE"        , new StringBuilder());
		mapSections.put("MAIN_CONTENT"      , new StringBuilder());

		BufferedReader objReader = new BufferedReader(new StringReader(strContents));
		String strLine;
		String strSection = null;
		try {
			while ((strLine = objReader.readLine()) != null) {
				Matcher objMatcher = REGEX_SECTIONSTART.matcher(strLine);
				if (objMatcher.matches()) {
					strSection = objMatcher.group(1);
					mapSections.put(strSection, new StringBuilder());
				}
				else {
					mapSections.get(strSection).append(strLine).append(System.getProperty("line.separator"));
				}
			}
		}
		catch (IOException objException) {}

		boolean boolIsValue = false;
		String strPropertyName = "";
		objReader = new BufferedReader(new StringReader(mapSections.get("DEFAULT_PROPERTIES").toString()));
		try {
			while ((strLine = objReader.readLine()) != null) {
				if (boolIsValue) {
					this.plDefaultProperties.add(strPropertyName, strLine);
				}
				else {
					strPropertyName = strLine;
				}
				boolIsValue = !boolIsValue;
			}
		}
		catch (IOException objException) {}

		this.strSideTitle = mapSections.get("SIDE_TITLE").toString();
		this.strSideContent = mapSections.get("SIDE_CONTENT").toString();
		this.strMainTitle = mapSections.get("MAIN_TITLE").toString();
		this.strMainContent = mapSections.get("MAIN_CONTENT").toString();
	}

	public PropertyList getDefaultProperties() {
		return this.plDefaultProperties;
	}

	public String getSideTitle() {
		return this.strSideTitle;
	}

	public String getSideContent() {
		return this.strSideContent;
	}

	public String getMainTitle() {
		return this.strMainTitle;
	}

	public String getMainContent() {
		return this.strMainContent;
	}

	public TemplatePage insert(TemplatePage objSourcePage) {
		TemplatePage objDestPage = new TemplatePage(this);

		objDestPage.plDefaultProperties = PropertyList.merge(objSourcePage.plDefaultProperties, objDestPage.plDefaultProperties);
		
		if (!objSourcePage.getSideTitle().isEmpty()) {
			objDestPage.strSideTitle = objSourcePage.getSideTitle();
		}
		if (!objSourcePage.getSideContent().isEmpty()) {
			objDestPage.strSideContent = objSourcePage.getSideContent();
		}
		if (!objSourcePage.getMainTitle().isEmpty()) {
			objDestPage.strMainTitle = objSourcePage.getMainTitle();
		}

		objDestPage.strMainContent = objDestPage.strMainContent.replace("${template-sidebar-title}", objDestPage.getSideTitle());
		objDestPage.strMainContent = objDestPage.strMainContent.replace("${template-sidebar-contents}", objDestPage.getSideContent());
		objDestPage.strMainContent = objDestPage.strMainContent.replace("${template-main-title}", objDestPage.getMainTitle());
		objDestPage.strMainContent = objDestPage.strMainContent.replace("${template-main-contents}", objSourcePage.getMainContent());

		return objDestPage;
	}

	public String process(Session objSession, PropertyList plPropertyList) {
		this.strMainContent = this.strMainContent.replace("${template-sessionid}",objSession.getKey());
		this.plDefaultProperties = PropertyList.merge(plPropertyList, this.plDefaultProperties);
		
		for (Map.Entry<String,String> objProperty : this.plDefaultProperties.entrySet()) {
			this.strMainContent = this.strMainContent.replace("${" + objProperty.getKey() + "}", objProperty.getValue());
		}

		this.strMainContent = REGEX_LEFTOVERPROPERTIES.matcher(this.strMainContent).replaceAll("");

		return this.strMainContent;
	}
}
