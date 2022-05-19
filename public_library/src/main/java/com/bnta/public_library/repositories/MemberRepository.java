package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    int findBookSizeByMember(Long id);

}
