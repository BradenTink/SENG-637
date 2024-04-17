**SENG 637- Dependability and Reliability of Software Systems\***

**Lab. Report \#5 – Software Reliability Assessment**
| Group \#: 7 |
| -------------- |
| Student Names: |
| Carissa Chung |
| Benjamin Reid |
| Braden Tink |
| Christian Valdez |
| Alton Wong |

# Introduction

Using failure data, we can assess the reliability of a system under test (SUT). Our group utilized the C-SFRAT reliability growth assessment tool to generate plots of the failure rate and reliability of the SUT. Reliability Demonstration Char (RDC) is a good method for checking whether the target mean time to failure (MTTF) is met. It is based on collecting failure data at various time points.

# Assessment Using Reliability Growth Testing

### Laplace Test

The **Laplace test** was used to determine the trend in the failure rate of a system. Failure data were collected and plotted to achieve a **90% confidence level**. The **x-axis** displays the failure count, while the **y-axis** shows the Laplace value.

<img width="1154" alt="Screenshot_2024-04-17_at_10 26 29_AM" src="https://github.com/BradenTink/SENG-637/assets/69766712/9e1d0d51-569c-47d2-95fa-1182e8199d30">

When the rate of change is **positive**, this indicates that the time between failures is decreasing, suggesting that failures are occurring more frequently. This could imply that the system or component is degrading or undergoing a wear-out process. Conversely, a **negative rate of change** suggests that the time between failures is increasing, implying that failures are becoming less frequent.

When the **Laplace value** is **above the red line**, it indicates that the system is likely becoming less reliable over time.

When the **Laplace value** is **below the red line**, this suggests an improvement in reliability.

| Interval | Trend Description                                   | Above Upper Threshold? | Interpretation                            |
| -------- | --------------------------------------------------- | ---------------------- | ----------------------------------------- |
| 0-30     | Decreasing sharply                                  | No                     | Improvement in reliability                |
| 30-50    | Initially significant improvement, then fluctuating | Yes and No             | Variable reliability, periods of concern  |
| 50-60    | Increasing sharply                                  | Yes                    | Deterioration in reliability              |
| 60-80    | Generally high with fluctuations                    | Yes                    | Continued concern for reliability         |
| 80-92    | Decreasing                                          | No                     | Indications of improvement in reliability |

### Model Ranking

Testing for this assessment utilized the C-SFRAT and followed the steps outlined in the paper "A Covariate Software Tool to Guide Test Activity Allocation." Thus, the Weibull (DW2), Geometric (GM), and Second Order Negative Binomial (NB2) models were used. The comparison, using the Critic Mean, showed the best models to be the GM with covariate F (Critic score of 1.000), and the GM with covariates F and C (Critic score of 0.981).

### Failure Intensity

<img width="1075" alt="Screenshot_2024-04-17_at_10 32 38_AM" src="https://github.com/BradenTink/SENG-637/assets/69766712/fd831d9c-b4c1-43a0-8555-7bdafa345f65">

![321737713-5eb206a2-bd0d-4a60-84c4-21e9f05f35ef](https://github.com/BradenTink/SENG-637/assets/69766712/f423b19c-65fc-4573-a7c8-82867b288498)

| Interval | Trend                                                     |
| -------- | --------------------------------------------------------- |
| 0-4      | High failure intensity, decreasing trend                  |
| 4-19     | Fluctuating failure intensity, general decrease           |
| 19-25    | High failure intensity with sharp increases and decreases |
| 25-32    | Lower failure intensity, fluctuating with slight increase |

Explanation:

- **0-4**: The testing starts with a very high failure count (peaking at time 2), which suggests a high failure intensity. However, it decreases by time 4, showing an improvement in reliability as initial defects are presumably being fixed.

- **4-19**: There are fluctuations in the failure count, with several points (e.g., time 9 and 19) showing increased failure intensity, but the overall trend is a general decrease, which might indicate that the software is becoming more reliable as testing progresses and bugs are fixed.

- **19-25**: There is a noticeable spike at times 19 and 20, followed by a drop, which could indicate the discovery and fixing of a batch of defects or the software being subjected to more rigorous tests. The trend is quite variable with sharp increases and decreases in failure intensity.

- **25-32**: Post time 25, the failure counts are lower than the earlier spikes but show some fluctuation. This could suggest a stabilization in the number of failures, with ongoing discovery and fixing of defects as the testing progresses.

#

# Comparison of Results

# Discussion on Similarity and Differences of the Two Techniques

# How the team work/effort was divided and managed

#

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
