/**
 * Copyright (c) 2015 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ding.cloud.gray.rule;

import com.ding.cloud.gray.predicate.DiscoveryEnabledPredicate;
import com.ding.cloud.gray.predicate.MetadataAwarePredicateAfter;
import com.netflix.loadbalancer.*;
import org.springframework.util.Assert;

/**
 * A simple {@link IRule} for matching the discovered server instances. The actual matching is being performed by the
 * registered instance of {@link DiscoveryEnabledPredicate} allowing to adjust the actual matching strategy.
 *
 * @author Jakub Narloch
 * @see DiscoveryEnabledPredicate
 */
public abstract class DiscoveryEnabledRule extends ZoneAvoidanceRule {

    private final CompositePredicate predicate;

    /**
     * Creates new instance of {@link DiscoveryEnabledRule} class with specific predicate.
     *
     * @param discoveryEnabledPredicate the discovery enabled predicate, can't be null
     */
    public DiscoveryEnabledRule(DiscoveryEnabledPredicate discoveryEnabledPredicate) {
        Assert.notNull(discoveryEnabledPredicate, "Parameter 'discoveryEnabledPredicate' can't be null");
        this.predicate = createCompositePredicate(discoveryEnabledPredicate, new MetadataAwarePredicateAfter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractServerPredicate getPredicate() {
        return predicate;
    }

    /**
     * Creates the composite predicate with fallback strategies.
     *
     * @param discoveryEnabledPredicate the discovery service predicate
     * @param abstractServerPredicate     the availability predicate
     * @return the composite predicate
     */
    private CompositePredicate createCompositePredicate(DiscoveryEnabledPredicate discoveryEnabledPredicate, AbstractServerPredicate abstractServerPredicate) {
        return CompositePredicate.withPredicates(discoveryEnabledPredicate, abstractServerPredicate)
                .build();
    }
}
