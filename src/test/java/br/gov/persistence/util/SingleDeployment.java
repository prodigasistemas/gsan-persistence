package br.gov.persistence.util;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

//@ArquillianSuiteDeployment
public class SingleDeployment {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "gsan-persistence-test.war")
                .addPackages(true, "br.gov.persistence.util")
                .addPackages(true, "br.gov.model")
                .addPackages(true, "br.gov.model.arrecadacao")
                .addPackages(true, "br.gov.model.arrecadacao.pagamento")
                .addPackages(true, "br.gov.model.atendimentopublico")
                .addPackages(true, "br.gov.model.batch")
                .addPackages(true, "br.gov.model.cadastro")
                .addPackages(true, "br.gov.model.cadastro.endereco")
                .addPackages(true, "br.gov.model.cobranca")
                .addPackages(true, "br.gov.model.cobranca.parcelamento")
                .addPackages(true, "br.gov.model.converter")
                .addPackages(true, "br.gov.model.faturamento")
                .addPackages(true, "br.gov.model.financeiro")
                .addPackages(true, "br.gov.model.micromedicao")
                .addPackages(true, "br.gov.model.operacao")
                .addPackages(true, "br.gov.model.util")
                .addPackages(true, "br.gov.servicos.arrecadacao")
                .addPackages(true, "br.gov.servicos.arrecadacao.pagamento")
                .addPackages(true, "br.gov.servicos.batch")
                .addPackages(true, "br.gov.servicos.cadastro")
                .addPackages(true, "br.gov.servicos.cobranca")
                .addPackages(true, "br.gov.servicos.cobranca.parcelamento")
                .addPackages(true, "br.gov.servicos.faturamento")
                .addPackages(true, "br.gov.servicos.micromedicao")
                .addPackages(true, "br.gov.servicos.operacao")
                .addPackages(true, "br.gov.servicos.operacao.to")
                .addPackages(true, "br.gov.servicos.to")
            .addAsResource("persistence-test.xml", "META-INF/persistence.xml");
    }
}