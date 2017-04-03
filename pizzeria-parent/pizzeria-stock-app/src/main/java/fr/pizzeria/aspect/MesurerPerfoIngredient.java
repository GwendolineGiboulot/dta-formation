package fr.pizzeria.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;
import fr.pizzeria.repo.PerformanceRepo;

@Aspect
@Component
public class MesurerPerfoIngredient {

	@Autowired
	private PerformanceRepo perfoDao;

	@Pointcut("execution(* fr.pizzeria.repo.IngredientRepository.*(..))") // expression
	private void methodesDao() {
	}

	@Around("methodesDao()")
	public Object rajouterCodeSiManquant(ProceedingJoinPoint pjp) throws Throwable {

		long before = System.currentTimeMillis();

		Object proceed = pjp.proceed();

		long after = System.currentTimeMillis();

		Performance perf = new Performance(pjp.getSignature().toString(), LocalDateTime.now(), (after - before));
		perfoDao.save(perf);

		return proceed;
	}

}
