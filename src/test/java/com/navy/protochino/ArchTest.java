package com.navy.protochino;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.navy.protochino");

        noClasses()
            .that()
            .resideInAnyPackage("com.navy.protochino.service..")
            .or()
            .resideInAnyPackage("com.navy.protochino.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.navy.protochino.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
