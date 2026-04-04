       int n = arr.length;
        int min = arr[0], max = arr[0];
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) min = Math.min(min, arr[i]);
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) max = Math.max(max, arr[i]);
        }
        return new int[]{min, max};
    }
