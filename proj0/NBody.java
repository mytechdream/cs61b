public class NBody {
    public static double readRadius(String filepath) {
          In in = new In(filepath);
          int num = in.readInt();
          double r =  in.readDouble();
          return r;
    }
    public static Planet[] readPlanets(String filepath) {
        In in = new In(filepath);
        int num = in.readInt();
        Planet[] planet = new Planet[num];
        double r =  in.readDouble();
        for(int i = 0;i<num;i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planet[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return planet;
    }
    public static void main(String[] args) {

           double t = 0;
           double T = Double.parseDouble(args[0]);
           double dt = Double.parseDouble(args[1]);
           Planet[] planets = readPlanets(args[2]);
           double r = readRadius(args[2]);
           StdDraw.enableDoubleBuffering();

           StdDraw.setScale(-r,r);

           double[] xForces = new double[planets.length];
           double[] yForces = new double[planets.length];
           StdDraw.picture(0 ,0,"images/starfield.jpg");
           for (Planet plant:planets) {
               plant.draw();
           }
           while(t<=T){
                StdDraw.clear();
                for(int i = 0;i<planets.length;i++) {
                    xForces[i] =  planets[i].calcNetForceExertedByX(planets);
                    yForces[i] =  planets[i].calcNetForceExertedByY(planets);
                }
               for(int i = 0;i<planets.length;i++) {
                   planets[i].update(t,xForces[i],yForces[i]);
               }
               StdDraw.picture(0 ,0,"images/starfield.jpg");
               for (Planet plant:planets) {
                   plant.draw();
                }
                StdDraw.show();
                StdDraw.pause(10);

                t+=dt;
           }

    }

}
