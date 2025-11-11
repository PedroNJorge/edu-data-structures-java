import java.util.*;

public class ED029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        
        for (int x = 0; x < c; x++) {
            int L = scanner.nextInt();
            int A = scanner.nextInt();
            
            // Read all planes and store them
            List<Plane> allPlanes = new ArrayList<>();
            
            // Read takeoff planes
            for (int i = 0; i < L; i++) {
                String name = scanner.next();
                int time = scanner.nextInt();
                allPlanes.add(new Plane(name, time, false));
            }
            
            // Read landing planes
            for (int i = 0; i < A; i++) {
                String name = scanner.next();
                int time = scanner.nextInt();
                allPlanes.add(new Plane(name, time, true));
            }
            
            // Sort all planes by their desired time (input is already sorted by type)
            Collections.sort(allPlanes, (p1, p2) -> Integer.compare(p1.time, p2.time));
            
            // Queues for ready planes
            Queue<Plane> takeoffReady = new LinkedList<>();
            Queue<Plane> landingReady = new LinkedList<>();
            
            // Results storage
            List<PlaneResult> results = new ArrayList<>();
            
            int currentTime = 0;
            int planeIndex = 0;
            int totalPlanes = L + A;
            
            while (results.size() < totalPlanes) {
                currentTime++;
                
                // Add all planes that become ready at or before current time
                while (planeIndex < totalPlanes && allPlanes.get(planeIndex).time <= currentTime) {
                    Plane p = allPlanes.get(planeIndex);
                    if (p.isLanding) {
                        landingReady.add(p);
                    } else {
                        takeoffReady.add(p);
                    }
                    planeIndex++;
                }
                
                // Skip if no planes are ready
                if (takeoffReady.isEmpty() && landingReady.isEmpty()) {
                    continue;
                }
                
                // Choose which plane gets the runway
                Plane chosen;
                
                if (!landingReady.isEmpty() && !takeoffReady.isEmpty()) {
                    // Calculate waiting times
                    Plane landing = landingReady.peek();
                    Plane takeoff = takeoffReady.peek();
                    int landingWait = currentTime - landing.time;
                    int takeoffWait = currentTime - takeoff.time;
                    
                    // Choose plane with longer waiting time, landing wins ties
                    if (landingWait > takeoffWait) {
                        chosen = landingReady.poll();
                    } else if (takeoffWait > landingWait) {
                        chosen = takeoffReady.poll();
                    } else {
                        chosen = landingReady.poll(); // Landing priority in case of tie
                    }
                } else if (!landingReady.isEmpty()) {
                    chosen = landingReady.poll();
                } else {
                    chosen = takeoffReady.poll();
                }
                
                // Calculate delay and store result
                int delay = currentTime - chosen.time;
                results.add(new PlaneResult(chosen.name, delay, chosen.isLanding));
            }
            
            // Output results
            System.out.println(L + " " + A);
            
            // Output takeoff planes first
            for (PlaneResult result : results) {
                if (!result.isLanding) {
                    System.out.println(result.name + " " + result.delay);
                }
            }
            
            // Output landing planes
            for (PlaneResult result : results) {
                if (result.isLanding) {
                    System.out.println(result.name + " " + result.delay);
                }
            }
        }
        scanner.close();
    }
    
    static class Plane {
        String name;
        int time;
        boolean isLanding;
        
        Plane(String name, int time, boolean isLanding) {
            this.name = name;
            this.time = time;
            this.isLanding = isLanding;
        }
    }
    
    static class PlaneResult {
        String name;
        int delay;
        boolean isLanding;
        
        PlaneResult(String name, int delay, boolean isLanding) {
            this.name = name;
            this.delay = delay;
            this.isLanding = isLanding;
        }
    }
}
