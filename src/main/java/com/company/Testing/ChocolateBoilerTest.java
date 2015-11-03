package com.company.Testing;

import com.company.mx.iteso.boilers.ChocolateBoiler;
import org.junit.Before;
import org.junit.Test;

import java.lang.Override;
import java.lang.Runnable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class ChocolateBoilerTest
{
    @Test
    public void Test()
    {
        Callable<ChocolateBoiler> c = new Callable<ChocolateBoiler>() {
            public ChocolateBoiler call() throws Exception {
                return ChocolateBoiler.getInstance();
            }
        };
        ExecutorService ex = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 30; i++) {
            Future<ChocolateBoiler> f1 = ex.submit(c);
            Future<ChocolateBoiler> f2 = ex.submit(c);
            try{
                assertEquals(f1.get(), f2.get());
            }catch(Exception e)
            {

            }
        }
    }
}
