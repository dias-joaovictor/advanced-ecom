FROM prom/prometheus

COPY prometheus.yml /etc/prometheus/prometheus.yml.template

# Preprocess the configuration file using envsubst
CMD envsubst < /etc/prometheus/prometheus.yml.template > /etc/prometheus/prometheus.yml && \
    /bin/prometheus --config.file=/etc/prometheus/prometheus.yml