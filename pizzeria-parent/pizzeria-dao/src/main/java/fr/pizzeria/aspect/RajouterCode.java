package fr.pizzeria.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class RajouterCode {

	@Pointcut("execution(* saveNew(..))") // expression
	private void methodesSave() {
	}

	@Before("methodesSave()")
	public void rajouterCodeSiManquant(JoinPoint jp) {

		Pizza piz = (Pizza) jp.getArgs()[0];

		if (piz.getCode() == null || piz.getCode() == "") {
			piz.setCode(piz.getNom().substring(0, 3).toUpperCase());
		}

	}

}
