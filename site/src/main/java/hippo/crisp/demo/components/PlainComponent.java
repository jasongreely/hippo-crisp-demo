package hippo.crisp.demo.components;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.crisp.api.broker.ResourceServiceBroker;
import org.onehippo.cms7.crisp.api.resource.Resource;
import org.onehippo.cms7.essentials.components.EssentialsContentComponent;
import org.onehippo.cms7.services.HippoServiceRegistry;

import javax.imageio.spi.ServiceRegistry;

/**
 * Created by jgreely on 3/12/18.
 */
public class PlainComponent extends EssentialsContentComponent {

    private static String PLAIN_TEXT_RESOURCE = "plainTextResource";
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response){
        ResourceServiceBroker broker = HippoServiceRegistry.getService(ResourceServiceBroker.class);
        Resource plainResource = broker.resolve(PLAIN_TEXT_RESOURCE, "");
        String result = plainResource.toString();
        request.setAttribute("result", result);
    }
}
