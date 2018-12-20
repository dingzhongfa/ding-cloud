/**
 * Copyright (c) 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ding.cloud.gray.predicate;

import com.ding.cloud.gray.api.RibbonFilterContext;
import com.ding.cloud.gray.support.RibbonFilterContextHolder;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.ding.cloud.gray.constant.GrayConstants.GRAY_KEY;

/**
 * A default implementation of {@link DiscoveryEnabledServer} that matches the instance against the attributes
 * registered through
 *
 * @author Jakub Narloch
 * @see DiscoveryEnabledPredicate
 */
public class MetadataAwarePredicate extends DiscoveryEnabledPredicate {

    private static final Logger logger = LoggerFactory.getLogger(MetadataAwarePredicate.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean apply(DiscoveryEnabledServer server) {

        final RibbonFilterContext context = RibbonFilterContextHolder.getCurrentContext();
        final Map<String, String> attributes = context.getAttributes();
        final Map<String, String> metadata = server.getInstanceInfo().getMetadata();
        if (attributes.get(GRAY_KEY) == null || metadata.get(GRAY_KEY) == null) {
            return true;
        }
        boolean result = attributes.get(GRAY_KEY).equals(metadata.get(GRAY_KEY));
        if (result){
            RibbonFilterContextHolder.getCurrentContext().addGrayCount();
        }
        logger.info("result is {}", result);
        return result;
    }
}
