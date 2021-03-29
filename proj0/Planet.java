public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;

    }

    public double calcDistance(Planet b) {
        double distance = (b.xxPos - xxPos) * (b.xxPos - xxPos) + (b.yyPos - yyPos) * (b.yyPos - yyPos);
        return Math.sqrt(distance);
    }

    public double calcForceExertedBy(Planet b) {
        double r = calcDistance(b);
        double constantG = 6.67e-11;
        double force = constantG * mass * b.mass / r / r;
        return force;
    }

    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - xxPos;
        double force = calcForceExertedBy(b);
        double r = calcDistance(b);
        return force * dx / r;
    }

    public double calcForceExertedByY(Planet b) {
        double dy = b.yyPos - yyPos;
        double force = calcForceExertedBy(b);
        double r = calcDistance(b);
        return force * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] allbodys) {
        double netForce = 0.0;
        for (Planet b : allbodys) {
            if (!b.equals(this))
                netForce += calcForceExertedByX(b);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] allbodys) {
        double netForce = 0.0;
        for (Planet b : allbodys) {
            if (!b.equals(this))
                netForce += calcForceExertedByY(b);
        }
        return netForce;
    }

    public void update(double dt, double fX, double fY) {
        double xacc = fX / mass;
        double yacc = fY / mass;
        xxVel = xxVel + xacc * dt;
        yyVel = yyVel + yacc * dt;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        // System.out.printf("draw at %f %f\n", xxPos, yyPos);
    }
}
