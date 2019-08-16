package io.pivotal.support.rogueinstances.objects;


import javax.persistence.*;

@Entity
@Table(name="service_instances")
public class Instance {

    @Override
    public String toString() {
        return "Instance{" +
                "serviceInstanceId='" + serviceInstanceId + '\'' +
                ", space_guid='" + space_guid + '\'' +
                ", organization_guid='" + organization_guid + '\'' +
                '}';
    }

    public Instance() {

    }

    @Id
    @Column(name="serviceInstanceId")
    private String serviceInstanceId;

    @Column(name="space_guid")
    private String space_guid;

    @Column(name="organization_guid")
    private String organization_guid;

    public Instance(String inGUID, String spaceGUID, String orgGUID) {
        serviceInstanceId = inGUID;
        space_guid = spaceGUID;
        organization_guid = orgGUID;
    }

    public String getServiceInstanceId() {
        return serviceInstanceId;
    }

    public String getSpace_guid() {
        return space_guid;
    }

    public String getOrganization_guid() {
        return organization_guid;
    }

}
