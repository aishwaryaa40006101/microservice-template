package com.example.JavaTemplate.OuterLayer;
import com.example.JavaTemplate.Cancellation.CancellationToken;
import com.example.JavaTemplate.MiddleLayer.middleLayer;


public class outerLayer1 extends Thread{

    public String mainController() throws Exception {
        /*outerLayer ot=new outerLayer();
        ot.start();*/
        System.out.println("Outer Layer of the Microservice");
       // int startFlag = GettingUpdates();
       /* if (startFlag == 1)
        {
            System.out.println("Update service is running in background....");
        }*/
        //string LogPath = System.String.Concat(Directory.GetCurrentDirectory(), "/PrototypeMicroserviceLogs.txt");
        //Healthindicator healthindicator= Healthindicator.getInstance();

            CancellationToken token = new CancellationToken();
            middleLayer middleLayer1 = new middleLayer();
            middleLayer1.start(token);
            return "hello";

    }

  /*  private static int RunStartStop() {
        Copy stopAndStart = new Copy();
        int updatesFlag = GettingUpdates();
        int StartStopFlag = 0;
        if (updatesFlag == 1)
        {
            Console.WriteLine("Updates running in background....");
        }
        if (GettingUpdates().IsCompleted)
        {
            Thread startService;
            startService = new Thread(() => {

                    stopAndStart.Copy1();
            StartStopFlag = 1;

                });
            startService.IsBackground = true;
            startService.Start();
            Thread.Sleep(1000);
        }

        return StartStopFlag;
    }*/

   /* public void run(){
        FileFromActiveMq fileFromActiveMq =new FileFromActiveMq();
        int updates = 0;
        try {
            fileFromActiveMq.subscribeUpdates("D:\\Updates\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
        updates = 1;
    }*/
}
