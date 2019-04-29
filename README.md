# Airlines App Spring Boot Kubernetes Example

## Create namespace

```
$> kubectl create namespace devops-airlines-app
```

## Set configmap

```
kubectl -n devops-airlines-app create configmap config-app-develop --from-file=src/main/resources/application.properties
```

## Set Docker registry

```
$> kubectl create \
    secret docker-registry nexus-docker \
    --docker-server=nexus-local.tntformacion.com:10000 \
    --docker-username=admin \
    --docker-password=YOUR_PASSWORD \
    --docker-email=admin@example.org --namespace=devops-airlines-app
```

# Set secure tls

```
$> kubectl create secret tls secure-tls --key privkey1.pem --cert fullchain1.pem -n devops-airlines-app
```