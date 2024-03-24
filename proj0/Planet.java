public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        p.xxPos = this.xxPos;
        p.yyPos = this.yyPos;
        p.xxVel = this.xxVel;
        p.yyVel = this.yyVel;
        p.mass = this.mass;
        p.imgFileName = this.imgFileName;
    }
    public boolean equals(Planet p) {
        if (p.xxPos == this.xxPos && p.yyPos == this.yyPos && p.mass == this.mass)
            return true;
        return false;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(
                (p.xxPos - this.xxPos) * (p.xxPos - this.xxPos)
                        + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));

    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * ((p.xxPos - this.xxPos) / (calcDistance(p)));
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * ((p.yyPos - this.yyPos) / (calcDistance(p)));
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double sum = 0;
        for (Planet p_1 : p) {
            if (this.equals(p_1))
                continue;
            sum += calcForceExertedByX(p_1);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double sum = 0;
        for (Planet p_1 : p) {
            if (this.equals(p_1))
                continue;
            sum += calcForceExertedByY(p_1);
        }
        return sum;
    }
}