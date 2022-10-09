package tech.mathieu.ebook;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookEntity {
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Id
  @Column(name = "id", nullable = false)
  int id;

  @Column(name = "title", nullable = true, length = 4000)
  String title;

  @Column(name = "date", nullable = true, length = 4000)
  String date;

  @Column(name = "meta", nullable = true, length = 4000)
  String meta;

  @ManyToMany(
      targetEntity = CreatorEntity.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.MERGE
  )
  @JoinTable(
      name = "CREATOR2BOOK",
      joinColumns = @JoinColumn(name = "BOOK_ID"),
      inverseJoinColumns = @JoinColumn(name = "CREATOR_ID")
  )
  List<CreatorEntity> creatorEntities;

  @ManyToMany(
      targetEntity = ContributorEntity.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.MERGE
  )
  @JoinTable(
      name = "contributor2book",
      joinColumns = @JoinColumn(name = "BOOK_ID"),
      inverseJoinColumns = @JoinColumn(name = "contributor_id")
  )
  List<ContributorEntity> contributorEntities;

  @ManyToMany(
      targetEntity = LanguageEntity.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.MERGE
  )
  @JoinTable(
      name = "language2book",
      joinColumns = @JoinColumn(name = "BOOK_ID"),
      inverseJoinColumns = @JoinColumn(name = "language_id")
  )
  List<LanguageEntity> languageEntities;

  @ManyToMany(
      targetEntity = PublisherEntity.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.MERGE
  )
  @JoinTable(
      name = "publisher2book",
      joinColumns = @JoinColumn(name = "BOOK_ID"),
      inverseJoinColumns = @JoinColumn(name = "publisher_id")
  )
  List<PublisherEntity> publisherEntities;

  @ManyToMany(
      targetEntity = SubjectEntity.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.MERGE
  )
  @JoinTable(
      name = "subject2book",
      joinColumns = @JoinColumn(name = "BOOK_ID"),
      inverseJoinColumns = @JoinColumn(name = "subject_id")
  )
  List<SubjectEntity> subjectEntities;

  @OneToMany(mappedBy = "book",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  private List<IdentifierEntity> identifierEntities;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getMeta() {
    return meta;
  }

  public void setMeta(String meta) {
    this.meta = meta;
  }

  public List<CreatorEntity> getCreatorEntities() {
    return creatorEntities;
  }

  public void setCreatorEntities(List<CreatorEntity> creatorEntities) {
    this.creatorEntities = creatorEntities;
  }

  public List<IdentifierEntity> getIdentifierEntities() {
    return identifierEntities;
  }

  public void setIdentifierEntities(List<IdentifierEntity> identifierEntities) {
    this.identifierEntities = identifierEntities;
  }

  public List<LanguageEntity> getLanguageEntities() {
    return languageEntities;
  }

  public void setLanguageEntities(List<LanguageEntity> languageEntities) {
    this.languageEntities = languageEntities;
  }

  public List<ContributorEntity> getContributorEntities() {
    return contributorEntities;
  }

  public void setContributorEntities(List<ContributorEntity> contributorEntities) {
    this.contributorEntities = contributorEntities;
  }

  public List<PublisherEntity> getPublisherEntities() {
    return publisherEntities;
  }

  public void setPublisherEntities(List<PublisherEntity> publisherEntities) {
    this.publisherEntities = publisherEntities;
  }

  public List<SubjectEntity> getSubjectEntities() {
    return subjectEntities;
  }

  public void setSubjectEntities(List<SubjectEntity> subjectEntities) {
    this.subjectEntities = subjectEntities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BookEntity that)) {
      return false;
    }
    return id == that.id && Objects.equals(title, that.title) && Objects.equals(date, that.date) && Objects.equals(meta, that.meta) && Objects.equals(creatorEntities, that.creatorEntities) && Objects.equals(contributorEntities, that.contributorEntities) && Objects.equals(identifierEntities, that.identifierEntities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, date, meta, creatorEntities, contributorEntities, identifierEntities);
  }
}
