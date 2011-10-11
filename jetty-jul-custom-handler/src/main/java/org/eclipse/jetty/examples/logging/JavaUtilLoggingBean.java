package org.eclipse.jetty.examples.logging;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.jetty.util.component.AbstractLifeCycle;

public class JavaUtilLoggingBean extends AbstractLifeCycle
{
    @Override
    protected void doStart() throws Exception
    {
        super.doStart();

        // Tempting as it may be to use LogManager.readConfiguration() methods
        // it will not work as the LogManager classloader does not contain the
        // required custom classes you want to use.
        LogManager logmgr = LogManager.getLogManager();
        logmgr.reset();
        Logger root = logmgr.getLogger(""); // root logger
        root.addHandler(new CustomHandler());
    }
}
