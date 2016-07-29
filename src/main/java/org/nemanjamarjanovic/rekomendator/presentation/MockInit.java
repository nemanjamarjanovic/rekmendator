package org.nemanjamarjanovic.rekomendator.presentation;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import org.nemanjamarjanovic.rekomendator.bussines.Mock;

/**
 *
 * @author nemanja.marjanovic
 */
@Model
public class MockInit
{

    @EJB
    Mock mock;

    public void init()
    {
        mock.createMockData();
        mock.createMockData1();
        mock.createMockData2();
        mock.createMockData4();
    }
}
