package se.kth.mal.transformator.model;

public class Association {
    private AssociationEnd source;
    private AssociationEnd sink;
    private String name;

    public AssociationEnd getSource() {
        return source;
    }

    public void setSource(AssociationEnd source) {
        this.source = source;
    }

    public AssociationEnd getSink() {
        return sink;
    }

    public void setSink(AssociationEnd sink) {
        this.sink = sink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
