package kchcinemas;

import java.io.IOException;

/**
 *
 * @author darthcrap
 */
public class TemplateEngine {
	private static TemplatePage objTemplatePage = null;

	private static boolean initialize() {
		if (objTemplatePage == null) {
			objTemplatePage = loadPage("kchcinemas/pages/data/template.dat");
		}
		return (objTemplatePage != null);
	}

	private static TemplatePage loadPage(String strPath) {
		TemplatePage objPage = null;
		try {
			String strPage = HTTPServer.getResourceAsString(strPath);
			if (strPage == null) {
				throw new IOException();
			}
			objPage = new TemplatePage(strPage);
		}
		catch (IOException objException) {
			objPage = null;
		}
		return objPage;
	}

	public static Response produce(Session objSession, String strFile, PropertyList objPropertyList) {
		if (!initialize()) {
			return ResponseFactory.createErrorResponse(500, "Template Engine Error", "Could not load template data file");
		}

		TemplatePage objPage = loadPage(strFile);
		if (objPage == null) {
			return ResponseFactory.createErrorResponse(500, "Template Engine Error", "Could not load " + strFile);
		}

		objPage = objTemplatePage.insert(objPage);

		Response objResponse = new Response();
		objResponse.setContents(objPage.process(objSession, objPropertyList));
		return objResponse;
	}
}
