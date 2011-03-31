package kchcinemas.pages.handlers;

import java.io.IOException;
import java.util.regex.Matcher;
import kchcinemas.PropertyList;
import kchcinemas.RequestHandler;
import kchcinemas.Response;
import kchcinemas.ResponseFactory;
import kchcinemas.Session;

/**
 *
 * @author darthcrap
 */
public class IndexHandler extends RequestHandler {
	@Override
	public Response getResponse(Session objSession, PropertyList plProperties, Matcher objMatcher) throws IOException {
		return ResponseFactory.createRedirectResponse("/login");
	}

	@Override
	public boolean needsUser() {
		return false;
	}

	@Override
	public boolean needsSession() {
		return true;
	}
}
