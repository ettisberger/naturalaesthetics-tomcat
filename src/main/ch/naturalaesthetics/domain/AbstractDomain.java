package main.ch.naturalaesthetics.domain;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class AbstractDomain {

    private int id;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }
}
