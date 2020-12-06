package com.studiomediatech.example.varnished.app.frobulator.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


/**
 * So there you are, minding your own business, when suddenly you get a CRUD repository thrown in your lap. It just
 * WORKS you think to yourself, and go happily about your business... until. But this is not the time for angst or
 * fear, enjoy your little moment, and take it for what it is - a CRUD repository for your CRUD crap. Now listen, this
 * stuff really works great, but you'll have to bend to the will of those 80% simple use-cases, in which case you've
 * only spent 20% of effort!
 */
@Repository
public interface FrobulatorEntityRepository extends CrudRepository<FrobulatorEntity, Long> {

    // OK
}
