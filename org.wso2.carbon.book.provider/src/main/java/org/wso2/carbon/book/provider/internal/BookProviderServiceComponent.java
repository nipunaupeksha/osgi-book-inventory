package org.wso2.carbon.book.provider.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.book.provider.BookProvider;
import org.wso2.carbon.book.provider.BookProviderImpl;

import java.util.logging.Logger;

@Component(
        name = "org.wso2.carbon.book.provider",
        immediate = true
)

public class BookProviderServiceComponent {
    private static final Logger LOGGER = Logger.getLogger(BookProviderServiceComponent.class.getName());

    @Activate
    protected void activate(ComponentContext context) {
        try {
            BundleContext bundleContext = context.getBundleContext();
            bundleContext.registerService(BookProvider.class, BookProviderImpl.getInstance(), null);
            LOGGER.info("Book provider bundle is activated");
        } catch (Throwable th) {
            LOGGER.info("Error: " + th);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        LOGGER.info("Book provider bundle is deactivated");
    }
}
