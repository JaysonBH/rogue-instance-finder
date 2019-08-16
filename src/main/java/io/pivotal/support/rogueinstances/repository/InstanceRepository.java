package io.pivotal.support.rogueinstances.repository;

import io.pivotal.support.rogueinstances.objects.Instance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface InstanceRepository extends CrudRepository<Instance, String> {

    Boolean existsByServiceInstanceId(String serviceInstanceGUID);

}