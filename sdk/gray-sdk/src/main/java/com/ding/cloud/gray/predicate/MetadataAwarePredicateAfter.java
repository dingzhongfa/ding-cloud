package com.ding.cloud.gray.predicate;

import com.ding.cloud.gray.api.RibbonFilterContext;
import com.ding.cloud.gray.support.RibbonFilterContextHolder;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.ding.cloud.gray.constant.GrayConstants.GRAY_KEY;

/**
 * <p>
 * todo
 * </p>
 * <p>Company: www.kktalkee.com</p>
 *
 * @author dingzhongfa
 * @date 2018-12-12 11:28
 */
public class MetadataAwarePredicateAfter extends DiscoveryEnabledPredicate {

    private static final Logger logger = LoggerFactory.getLogger(MetadataAwarePredicate.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean apply(DiscoveryEnabledServer server) {
        if (RibbonFilterContextHolder.getCurrentContext().getGrayCount() == 0) {
            return true;
        }
        final RibbonFilterContext context = RibbonFilterContextHolder.getCurrentContext();
        final Map<String, String> attributes = context.getAttributes();
        final Map<String, String> metadata = server.getInstanceInfo().getMetadata();
        boolean result = attributes.get(GRAY_KEY).equals(metadata.get(GRAY_KEY));
        logger.info("result is {}", result);
        return result;
    }
}