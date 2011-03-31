package kchcinemas;

import java.io.IOException;
import java.util.regex.Matcher;

public abstract class RequestHandler {
	public abstract Response getResponse(Session objSession, PropertyList plParameters, Matcher objMatcher) throws IOException;
	public abstract boolean needsUser();
	public abstract boolean needsSession();
}
