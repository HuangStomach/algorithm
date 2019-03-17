import edu.princeton.cs.algs4.*;
import java.awt.Color;

class CollisionSystem {
    private MinPQ<Event> pq;
    private double t = 0.0;
    private Particle[] particles;
    private class Event implements Comparable<Event> {
        private final double time;
        private final Particle a, b;
        private final int countA, countB;
        private int type;

        public Event(double t, Particle a, Particle b, int type) {
            this.time = t;
            this.a = a;
            this.b = b;
            this.type = type;
            if (a != null) countA = a.count();
            else countA = -1;

            if (b != null) countB = b.count();
            else countB = -1;
        }

        public int compareTo(Event that) {
            if (this.time < that.time) return -1;
            else if (this.time > that.time) return +1;
            else return 0;
        }

        public boolean isValid() {
            if (a != null && a.count() != countA) return false;
            if (b != null && b.count() != countB) return false;
            return true;
        }
    }

    public CollisionSystem(Particle[] particles) {
        this.particles = particles;
    }

    public void redraw(double limit, double Hz) {
        StdDraw.clear();
        for (int i = 0; i < particles.length; i++) {
            particles[i].draw();
        }
        StdDraw.show(20);
        if (t < limit) {
            pq.insert(new Event(t + 1.0 / Hz, null, null));
        }
    }

    private void predictCollisions(Particle a, double limit) {
        if (a == null) return;
        for (int i = 0; i < particles.length; i++) {
            double dt = a.timeToHit(particles[i]);
            if (t + dt <= limit) {
                pq.insert(new Event(t + dt, a, particles[i], 0));
            }
        }

        double dtX = a.timeToHitXWall();
        if (t + dtX <= limit) {
            pq.insert(new Event(t + dtX, a, null, 1));
        }

        double dtY = a.timeToHitYWall();
        if (t + dtY <= limit) {
            pq.insert(new Event(t + dtY, a, null, 2));
        }

        double dtZ = a.timeToHitZWall();
        if (t + dtZ <= limit) {
            pq.insert(new Event(t + dtZ, a, null, 3));
        }
    }

    public void simulate(double limit, double Hz) {
        pq = new MinPQ<Event>();
        for (int i = 0; i < particles.length; i++) {
            predictCollisions(particles[i], limit);
        }
        pq.insert(new Event(0, null, null));
        while (!pq.isEmpty()) {
            Event event = pq.delMin();
            if (!event.isValid()) continue;
            for (int i = 0; i < particles.length; i++) {
                particles[i].move(event.time - t);
            }
            t = event.time;
            type = event.type;
            Particle a = event.a;
            Particle b = event.b;

            if (a != null && b != null) a.bounceOff(b);
            else if (a != null && type == 1) a.bounceOffXWall();
            else if (a != null && type == 2) a.bounceOffYWall();
            else if (a != null && type == 3) a.bounceOffZWall();
            else if (a == null && b == null) redraw(limit, Hz);
            predictCollisions(a, limit);
            predictCollisions(b, limit);
        }
    }

    public static void main(String[] args) {
        StdDraw.show(0);
        int N = Integer.parseInt(args[0] ? args[0] : 10);
        Particle[] particles = new Particle[N];

        for (int i = 0; i < N; i++) {
            particles[i] = new Particle();
        }
        CollisionSystem system = new CollisionSystem(particles);
        system.simulate(10000, 0.5);
    }
}

class Particle {
    private static final double INFINITY = Double.POSITIVE_INFINITY;

    private double rx, ry, rz; // position
    private double vx, vy, vz; // velocity
    private int count; // number of collisions so far
    private final double radius; // radius
    private final double mass; // mass
    private final Color color; // color

    public Particle(double rx, double ry, double rz, double vx, double vy, double vz, double radius, double mass, Color color) {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.radius = radius;
        this.mass   = mass;
        this.color  = color;
    }

    public Particle() {
        rx = StdRandom.uniform(0.0, 1.0);
        ry = StdRandom.uniform(0.0, 1.0);
        rz = StdRandom.uniform(0.0, 1.0);
        vx = StdRandom.uniform(-0.005, 0.005);
        vy = StdRandom.uniform(-0.005, 0.005);
        vz = StdRandom.uniform(-0.005, 0.005);
        radius = 0.02;
        mass = 0.5;
        color = Color.BLACK;
    }

    public void move(double dt) {
        rx += vx * dt;
        ry += vy * dt;
        rz += vz * dt;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, rz); // 将z轴高度当做点的大小
    }

    public int count() {
        return count;
    }

    public double timeToHit(Particle that) {
        if (this == that) return INFINITY;
        double dx  = that.rx - this.rx;
        double dy  = that.ry - this.ry;
        double dz  = that.rz - this.rz;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvz = that.vy - this.vz;
        double dvdr = dx * dvx + dy * dvy + dz * dvz;
        if (dvdr > 0) return INFINITY;
        double dvdv = dvx * dvx + dvy * dvy + dvz * dvz;
        if (dvdv == 0) return INFINITY;
        double drdr = dx * dx + dy * dy + dz * dz;
        double sigma = this.radius + that.radius;
        double d = (dvdr * dvdr) - dvdv * (drdr - sigma * sigma);
        
        if (d < 0) return INFINITY;
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }

    public double timeToHitXWall() {
        if (vx > 0) return (1.0 - rx - radius) / vx;
        else if (vx < 0) return (radius - rx) / vx;  
        else return INFINITY;
    }

    public double timeToHitYWall() {
        if (vy > 0) return (1.0 - ry - radius) / vy;
        else if (vy < 0) return (radius - ry) / vy;
        else return INFINITY;
    }

    public double timeToHitZWall() {
        if (vz > 0) return (1.0 - rz - radius) / vz;
        else if (vz < 0) return (radius - rz) / vz;
        else return INFINITY;
    }

    public void bounceOff(Particle that) {
        double dx  = that.rx - this.rx;
        double dy  = that.ry - this.ry;
        double dz  = that.rz - this.rz;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvz = that.vz - this.vz;
        double dvdr = dz * dvz + dy * dvy + dz * dvz;// dv dot dr
        double dist = this.radius + that.radius;   // distance between particle centers at collison

        // magnitude of normal force
        double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);

        // normal force, and in x and y directions
        double fx = magnitude * dx / dist;
        double fy = magnitude * dy / dist;
        double fz = magnitude * dz / dist;

        // update velocities according to normal force
        this.vx += fx / this.mass;
        this.vy += fy / this.mass;
        this.vz += fz / this.mass;
        that.vx -= fx / that.mass;
        that.vy -= fy / that.mass;
        that.vz -= fz / that.mass;

        // update collision counts
        this.count++;
        that.count++;
    }

    public void bounceOffXWall() {
        vx = -vx;
        count++;
    }

    public void bounceOffYWall() {
        vy = -vy;
        count++;
    }

    public void bounceOffZWall() {
        vz = -vz;
        count++;
    }

    public double kineticEnergy() {
        return 0.5 * mass * (vx * vx + vy * vy + vz * vz);
    }
}