package ro.chronos.cqrsexample.config;

import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.common.transaction.ContainerTransactionManager;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class AxonConfiguration {

    private static final String userTransaction = "java:comp/UserTransaction";

    @PersistenceContext(name = "MyPU")
    private EntityManager em;

    @Produces
    public Configurer configurer() {
        return DefaultConfigurer.jpaConfiguration(new SimpleEntityManagerProvider(em));
    }

    @Produces
    public TransactionManager transactionManager() {
        return new ContainerTransactionManager(em, userTransaction);
    }
}
