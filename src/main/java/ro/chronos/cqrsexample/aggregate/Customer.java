package ro.chronos.cqrsexample.aggregate;

import org.axonframework.cdi.stereotype.Aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import ro.chronos.cqrsexample.api.CreateCustomerCommand;
import ro.chronos.cqrsexample.api.CustomerCreatedEvent;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Customer {

    @AggregateIdentifier
    private String customerId;

    @CommandHandler
    public Customer(CreateCustomerCommand cmd) {
        apply(new CustomerCreatedEvent(cmd.getCustomerId(), cmd.getFullName(), cmd.getAge()));
    }
}
