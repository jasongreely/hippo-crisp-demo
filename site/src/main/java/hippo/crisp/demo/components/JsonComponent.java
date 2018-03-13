package hippo.crisp.demo.components;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.crisp.api.broker.ResourceServiceBroker;
import org.onehippo.cms7.crisp.api.resource.Resource;
import org.onehippo.cms7.essentials.components.EssentialsContentComponent;
import org.onehippo.cms7.services.HippoServiceRegistry;

/**
 * Created by jgreely on 3/13/18.
 */
public class JsonComponent extends EssentialsContentComponent {

    private static String JSON_RESOURCE = "jsonResource";

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response){
        ResourceServiceBroker broker = HippoServiceRegistry.getService(ResourceServiceBroker.class);
        Resource plainResource = broker.resolve(JSON_RESOURCE, "/json");
        String result = plainResource.toString();
        request.setAttribute("result", result);
    }
}
