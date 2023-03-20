package org.springframework.cloud.openfeign.ribbon;

import feign.Client;

/**
 * Pacote removidos do spring mas que ainda estão na break changes para corrigirem.
 */
public class LoadBalancerFeignClient {
	
	public LoadBalancerFeignClient(Client delegate, CachingSpringLoadBalancerFactory lbClientFactory, SpringClientFactory clientFactory) {
		throw new UnsupportedOperationException();
	}
	
	public Client getDelegate() {
		throw new UnsupportedOperationException();
	}

}
