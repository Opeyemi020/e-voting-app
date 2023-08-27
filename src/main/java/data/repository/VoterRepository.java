package data.repository;

import data.models.Voter;

import java.util.Optional;

public interface VoterRepository {
    Optional<Voter> findByEmailAddress(String email);
}
