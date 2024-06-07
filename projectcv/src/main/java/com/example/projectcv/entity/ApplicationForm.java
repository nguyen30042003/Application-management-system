package com.example.projectcv.entity;

import com.example.projectcv.entity.composite_key.ApplicationFormKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "application_form")
public class ApplicationForm {
    @EmbeddedId
   private ApplicationFormKey id = new ApplicationFormKey();

    @ManyToOne(optional = false)
    @MapsId("recruitmentDetailKeyId")
    @JoinColumns({
            @JoinColumn(
                    name = "recruit_id", referencedColumnName = "recruit_id"
            ),
            @JoinColumn(
                    name = "nominee_id", referencedColumnName = "nominee_id"
            )
    } )
    private RecruitmentDetail recruitmentDetail;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumns(
            {
                    @JoinColumn(
                           referencedColumnName = "id"
                    )
            }
          )
    private Candidate candidate;



    @Column(name = "is_processed")
    private boolean isProcessed;
    @Column(name = "is_responded")
    private boolean isResponded;
}
