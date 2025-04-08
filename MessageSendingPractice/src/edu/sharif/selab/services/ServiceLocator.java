package edu.sharif.selab.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Service Locator pattern implementation
 * This addresses the Dependency Inversion Principle by providing a layer of indirection
 * between client code and service implementations
 */
public class ServiceLocator {
    private static final Map<Class<?>, Object> services = new HashMap<>();
    
    /**
     * Registers a service implementation for a specific interface
     * @param serviceInterface The service interface
     * @param implementation The implementation instance
     * @param <T> The type of service
     */
    public static <T> void register(Class<T> serviceInterface, T implementation) {
        services.put(serviceInterface, implementation);
    }
    
    /**
     * Gets a service implementation for a specific interface
     * @param serviceInterface The service interface
     * @param <T> The type of service
     * @return The service implementation
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> serviceInterface) {
        Object service = services.get(serviceInterface);
        if (service == null) {
            throw new IllegalArgumentException("No implementation registered for " + serviceInterface.getName());
        }
        return (T) service;
    }
    
    /**
     * Initialize the service locator with default services
     */
    public static void initialize() {
        register(MessageProcessor.class, new MessageProcessor());
    }
} 