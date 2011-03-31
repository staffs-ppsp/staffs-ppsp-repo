package kchcinemas.pages.handlers;

import kchcinemas.ResponseFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import kchcinemas.HTTPServer;
import kchcinemas.PropertyList;
import kchcinemas.RequestHandler;
import kchcinemas.Response;
import kchcinemas.Session;

/**
 *
 * @author darthcrap
 */
public class ResourceHandler extends RequestHandler {
	private static class Resource {
		private String strResourcePath = "";
		private String strContentType = "";

		public Resource(String strResourcePath, String strContentType) {
			if (strResourcePath == null) strResourcePath = "";
			if (strContentType == null) strContentType = "";
			this.strResourcePath = strResourcePath;
			this.strContentType = strContentType;
		}

		public String getResourcePath() {
			return this.strResourcePath;
		}

		public String getContentType() {
			return this.strContentType;
		}
	}

	private static final Map<String,Resource> mapResourceMap = new HashMap<String,Resource>();
	static {
		mapResourceMap.put("css/theme"     , new Resource("kchcinemas/resources/css/theme.css"    , "text/css"       ));
		mapResourceMap.put("css/page"      , new Resource("kchcinemas/resources/css/page.css"     , "text/css"       ));
		mapResourceMap.put("css/print"     , new Resource("kchcinemas/resources/css/print.css"    , "text/css"       ));
		mapResourceMap.put("js/protoype"   , new Resource("kchcinemas/resources/js/prototype.js"  , "text/javascript"));
		mapResourceMap.put("js/general"    , new Resource("kchcinemas/resources/js/general.js"    , "text/javascript"));
		mapResourceMap.put("js/empty"      , new Resource("kchcinemas/resources/js/empty.js"      , "text/javascript"));
		mapResourceMap.put("js/book_stage2", new Resource("kchcinemas/resources/js/book_stage2.js", "text/javascript"));

	}

	@Override
	public Response getResponse(Session objSession, PropertyList plProperties, Matcher objMatcher) throws IOException {
		Resource objResource = mapResourceMap.get(objMatcher.group(1));
		if (objResource == null) {
			return null;
		}
		else {
			//TODO: kchcinemas.handlers.ResourceHandler.getResponse(Matcher) -> Binary resources are corrupted. Possibly the inputstreamreader interpreting utf bytes where it shouldn't, even though it is set to ascii.
			return ResponseFactory.createOutputResponse(HTTPServer.getResourceAsString(objResource.getResourcePath()),objResource.getContentType());
		}
	}

	@Override
	public boolean needsUser() {
		return false;
	}

	@Override
	public boolean needsSession() {
		return false;
	}
}
