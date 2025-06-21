import pandas as pd
import matplotlib.pyplot as plt

# Load the generated dataset
df = pd.read_csv('generated_instagram_posts.csv')

# Calculate engagement percentage (views / followers) by hour
engagement_by_hour = df.groupby('hour').apply(lambda x: x['views'].sum() / x['followers'].sum() * 100)

# Calculate engagement percentage (views / followers) by time period
engagement_by_period = df.groupby('time_period').apply(lambda x: x['views'].sum() / x['followers'].sum() * 100)

# Print the engagement percentage by hour and time period
print("Engagement Percentage by Hour (Views / Followers * 100):")
print(engagement_by_hour)
print("\nEngagement Percentage by Time Period (Views / Followers * 100):")
print(engagement_by_period)

# Provide feedback on best hour and time period to post
best_hour = engagement_by_hour.idxmax()
best_hour_pct = engagement_by_hour.max()
best_period = engagement_by_period.idxmax()
best_period_pct = engagement_by_period.max()

print(f"\nFeedback:")
print(f"Post your videos at hour {best_hour} (which has the highest engagement percentage of {best_hour_pct:.2f}%).")
print(f"The best time period to post is '{best_period}' with an engagement percentage of {best_period_pct:.2f}%.")

# Plot engagement percentage by hour
plt.figure(figsize=(10, 5))
engagement_by_hour.plot(kind='bar', color='coral')
plt.title('Engagement Percentage by Hour (Views / Followers * 100)')
plt.xlabel('Hour of Day')
plt.ylabel('Engagement Percentage (%)')
plt.grid(axis='y', linestyle='--', alpha=0.7)
plt.tight_layout()
plt.show()

# Plot engagement percentage by time period
plt.figure(figsize=(8, 5))
engagement_by_period.reindex(['Morning', 'Afternoon', 'Evening', 'Night']).plot(kind='bar', color='skyblue')
plt.title('Engagement Percentage by Time Period (Views / Followers * 100)')
plt.xlabel('Time Period')
plt.ylabel('Engagement Percentage (%)')
plt.grid(axis='y', linestyle='--', alpha=0.7)
plt.tight_layout()
plt.show()
