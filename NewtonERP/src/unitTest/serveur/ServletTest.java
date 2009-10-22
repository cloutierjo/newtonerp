/**
 * 
 */
package unitTest.serveur;

import junit.framework.TestCase;
import newtonERP.ListModule;
import newtonERP.serveur.Servlet;

/**
 * @author djo
 * 
 */
public class ServletTest extends TestCase
{
    Servlet testServlet;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
	super.setUp();
	testServlet = new Servlet();
	ListModule.initAllModule();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
	super.tearDown();
    }

    /**
     * @throws Exception
     * 
     */
    public void testHandleFullAdress() throws Exception
    {
	// HttpServletRequestWrapper requ = new HttpServletRequestWrapper(null);

	assertNotNull(testServlet.urlToAction("/TestModule/TestAction", null));
    }

    /**
     * @throws Exception
     * 
     */
    public void testHandleNoAction() throws Exception
    {
	assertNotNull(testServlet.urlToAction("/TestModule", null));
    }

    /**
     * @throws Exception
     * 
     */
    public void testHandleNoModule() throws Exception
    {
	assertNotNull(testServlet.urlToAction("", null));
    }
}