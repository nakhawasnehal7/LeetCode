class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, List<Double>> weights = new HashMap<>();

        // Build bidirectional weighted graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            neighbors.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            weights.computeIfAbsent(a, k -> new ArrayList<>()).add(val);

            neighbors.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            weights.computeIfAbsent(b, k -> new ArrayList<>()).add(1.0 / val);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            results[i] = bfs(neighbors, weights, src, dst);
        }

        return results;
    }

    private double bfs(Map<String, List<String>> neighbors,
                       Map<String, List<Double>> weights,
                       String src, String dst) {

        if (!neighbors.containsKey(src) || !neighbors.containsKey(dst)) {
            return -1.0;
        }
        if (src.equals(dst)) {
            return 1.0;
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Double> product = new HashMap<>();
        queue.offer(src);
        product.put(src, 1.0);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            List<String> nbrs = neighbors.get(node);
            List<Double> wts = weights.get(node);

            for (int i = 0; i < nbrs.size(); i++) {
                String next = nbrs.get(i);
                double newProduct = product.get(node) * wts.get(i);

                if (next.equals(dst)) {
                    return newProduct;
                }

                if (!product.containsKey(next)) {
                    product.put(next, newProduct);
                    queue.offer(next);
                }
            }
        }

        return -1.0;
    }
}